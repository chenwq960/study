document.write(4444444444)

import Vue from "../node_modules/vue/dist/vue"
import VueRouter  from "vue-router"

import login  from "../src/login.vue"

Vue.use(VueRouter)

var routerObje = new VueRouter({
    routes:[
        {path:"/login",component:login}
    ]
})

/* var login = {
    template:"<h1>位数四大皆空放假快乐的说法</h1>"
} */

import application from "../src/app.vue"

var vm = new Vue({
    el:"#app",
    data:{
        mes:"我是",
    },
   render:c=>c(application),
   router:routerObje
})