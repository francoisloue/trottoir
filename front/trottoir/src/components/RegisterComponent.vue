<template>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Register</h5>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="email" id="loginName" class="form-control" v-model="email" />
                        <label class="form-label" for="loginName">Email</label>
                    </div>

                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="input" id="nameInput" class="form-control" v-model="name" />
                        <label class="form-label" for="nameInput">Name</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="input" id="surnameInput" class="form-control" v-model="surname" />
                        <label class="form-label" for="surnameInput">Surname</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="password" id="passwordInput" class="form-control" v-model="password" />
                        <label class="form-label" for="passwordInput">Password</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input type="password" id="confirmPasswordInput" class="form-control"
                            v-model="confirmPassword" />
                        <label class="form-label" for="confirmPasswordInput">Confirm password</label>
                    </div>
                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                        class="btn btn-primary btn-block mb-4" v-on:click="register">Create Account</button>
                </div>
                <div class="alert alert-warning" role="alert" v-if="errorMessage != null">
                    {{ errorMessage }}
                </div>
                <div>
                    <a href="/login">Already a account ?</a>
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
            confirmPassword: null,
            surname: null,
            name: null,
            errorMessage: null
        };
    },
    methods: {
        async register() {
            try {
                const data = {
                    "email": this.email,
                    "password": this.password,
                    "name": this.name,
                    "surname": this.surname,
                }
                if (this.password !== this.confirmPassword) {
                    this.errorMessage = "Pas le même mot de passe"
                    return
                }
                const req = await axios.post(import.meta.env.VITE_API_URL + "/users", data);
                console.log(req.statusText)
                if (req.status >= 200 && req.status < 300) {
                    this.$router.push("/login")
                    return
                } else if (req.status === 403) {
                    this.errorMessage = "Identifiant ou mot de passe incorrects";
                } else {
                    this.errorMessage = "Erreur avec le serveur";
                }
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