import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import PostView from '@/views/PostView.vue'
import ListPostView from '@/views/ListPostView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path : "/login",
      name : "login",
      component : LoginView,
    },
    {
      path : "/register",
      name : "register",
      component : RegisterView,
    },
    {
      path : "/createPost",
      name : "createPost", 
      component : PostView,
    },
    {
      path : "/posts",
      name : "posts",
      component : ListPostView,
    }
  ]
})

export default router
