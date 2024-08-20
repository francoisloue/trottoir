<template>
    <div class="container">
        <div class="row">
            <div v-if="errorMessage != null" class="col-12">
                <div class="alert alert-warning" role="alert">
                    {{ errorMessage }}
                </div>
            </div>

            <div v-for="post in posts" :key="post.id" class="col-md-4">
                <div class="card mb-4" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">{{ post.title }}</h5>
                        <p class="card-text">{{ post.content }}</p>
                        <p class="card-text">
                            <small class="text-muted">Auteur: {{ post.author.name }} {{ post.author.surname }}</small>
                        </p>
                        <p class="card-text">
                            <small class="text-muted">Likes: {{ post.likeCount }}</small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
import Cookies from 'js-cookie';

export default {
    data() {
        return {
            errorMessage: null,
            posts: []
        };
    },
    methods: {
        async getPosts() {
            try {
                const req = await axios.get(import.meta.env.VITE_API_URL + "/posts/all");
                if (req.status >= 200 && req.status < 300) {
                    this.posts = req.data;
                } else {
                    throw new Error("Code erreur différent de 2XX");
                }
            } catch (error) {
                if (error.response && error.response.status === 403) {
                    this.errorMessage = "Identifiant ou mot de passe incorrects";
                } else {
                    console.log(error);
                    this.errorMessage = "Erreur avec le serveur";
                }
            }
        }
    },
    async mounted() {
        if (!Cookies.get("userID")) {
            this.$router.push("/login");
        } else {
            await this.getPosts();
        }
    }
};
</script>
<style>
.card {
    margin-top: 25px;
}
</style>
