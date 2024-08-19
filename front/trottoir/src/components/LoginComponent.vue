<template>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Login</h5>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="email" id="loginName" class="form-control" v-model="email" />
                        <label class="form-label" for="loginName">Email</label>
                    </div>

                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="password" id="loginPassword" class="form-control" v-model="password" />
                        <label class="form-label" for="loginPassword">Password</label>
                    </div>
                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                        class="btn btn-primary btn-block mb-4" v-on:click="login">Sign in</button>
                </div>
                <div class="alert alert-warning" role="alert" v-if="errorMessage != null">
                    {{ errorMessage }}
                </div>
                <div>
                    <a href="/register">No Account ?</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import Cookies from 'js-cookie'

export default {
    data() {
        return {
            email: null,
            password: null,
            errorMessage: null
        };
    },
    methods: {
        async login() {
            try {
                const req = await axios.post(import.meta.env.VITE_API_URL + "/login", {
                    "email": this.email,
                    "password": this.password
                });
                if (req.status >= 200 && req.status < 300) {
                    if (req.data === 0) this.errorMessage = "Email ou mot de passe incorrect"
                    else this.errorMessage = "Faire l'apres identification OK"
                } else throw Error("Code erreur different de 2XX")

            } catch (error) {
                if (error.response && error.response.status === 403) {
                    this.errorMessage = "Identifiant ou mot de passe incorrects";
                } else {
                    this.errorMessage = "Erreur avec le serveur";
                }
            }
        }
    },
    mounted() {
        // Actions à effectuer lors du montage du composant
    }
};
</script>

<style>
.card {
    margin-top: 25px;
}
</style>