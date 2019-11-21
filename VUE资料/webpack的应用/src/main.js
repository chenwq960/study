

import Vue from "vue"                   //安装vue组将
import VueRouter from "vue-router"      //安装vuerouter的组将

import app from '../src/app.vue'        //导入组件
import qin from "../src/vue/header.vue" //导入秦朝的模块
import zhao from "../src/vue/zhao.vue"  //导入赵国的模块
import wei from "../src/vue/wei.vue"    //导入魏国的模块


//实例出来一个组将
var router = new VueRouter({
    routes:[
        {path:"/qin",component:qin},
        {path:"/zhao",component:zhao},
        {path:'/wei',component:wei}
    ]
})


Vue.use(VueRouter)

var vm = new Vue({
    el:"#app",
    data:{
        mes:"我是陈文庆"
    },
     render:c=>c(app),
    /* component:{
        app
    } */
    router
})






document.write("zhe")