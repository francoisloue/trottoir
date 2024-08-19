<script setup>
import { RouterLink, RouterView } from 'vue-router'
// import HeadComponent from './components/HeadComponent.vue';
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import 'bootstrap/dist/css/bootstrap.min.css'

</script>

<template>
  <div class="container">
    <RouterView />
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  align-items: center;

}
</style>