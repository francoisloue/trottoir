<template>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Write a Tro't</h5>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="input" id="inputTitle" class="form-control" v-model="title" />
                        <label class="form-label" for="inputTitle">Title</label>
                    </div>

                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="input" id="inputContent" class="form-control" v-model="content" maxlength="144" />
                        <label class="form-label" for="inputContent">content</label>
                    </div>
                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                        class="btn btn-primary btn-block mb-4" v-on:click="createPost">Create Trot't</button>
                </div>
                <div class="alert alert-warning" role="alert" v-if="errorMessage != null">
                    {{ errorMessage }}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import Cookies from 'js-cookie';

export default {
    data() {
        return {
            title: null,
            content: null,
            errorMessage: null
        };
    },
    methods: {
        async createPost() {
            try {
                const req = await axios.post(import.meta.env.VITE_API_URL + "/posts", {
                    "title": this.title,
                    "authorId": Cookies.get("userID"),
                    "content": this.content
                });
                if (req.status >= 200 && req.status < 300) {
                    this.errorMessage = "Trot's created"
                } else throw Error("Code erreur different de 2XX")

            } catch (error) {
                if (error.response && error.response.status === 403) {
                    this.errorMessage = "Identifiant ou mot de passe incorrects";
                } else {
                    console.log(error)
                    this.errorMessage = "Erreur avec le serveur";
                }
            }
        }
    },
    mounted() {
        if (!Cookies.get("userID")) this.$router.push("/login");
    }
};
</script>

<style>
.card {
    margin-top: 25px;
}
</style>