import Vue from 'vue'
import Router from 'vue-router'
import Math from '@/components/Math'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Math',
      component: Math
    }
  ]
})
