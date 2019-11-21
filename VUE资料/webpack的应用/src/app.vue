<template>
   <div>
       <header class="header">

        <router-link to="/qin">秦</router-link>
        <router-link to="/zhao">赵</router-link>
        <router-link to="/wei">清</router-link>

        
       </header>

       




        


        <router-view></router-view>
        4544444444444444444444444444
   </div>
</template>


<script>
export default {
    
}
</script>

<style>
    header > *{
        border: 1px solid red;
        padding-left: 50px;
        padding-top: 10px;
        font-size:30px;
        

    }
    header{
        margin: 30px 0px;
    }
    router-link{
        text-decoration:none;
    }

    
</style>