<template>
    <div class="qin">
        <div class="header">
            <label>
                ID:
                <input type="text" v-model="id">
            </label>

            <label>
                Name:
                <input type="text" v-model="name">
            </label>
            <button v-on:click=add()>提交</button>
            
              <label>
                搜索关键字:
                <input type="text" v-model="keyword" v-focus>
            </label>
        </div>
        <table>
            <tr>
                <td>ID:</td>
                <td>Name:</td>
                <td>Ctime:</td>
                <td>操作</td>
            </tr>
            <tr v-for="item in seach(keyword)" id="item.id">
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>{{item.ctime | mytime}}</td>
                <td>
                    <input  v-on:click=del(item.id) type="button" value="删除">
                </td>
            </tr>
        </table>
    </div>
</template>
<script>
export default {
    data(){
        return{
            list:[
                {id:1,name:"百里奚",ctime:new Date()},
                {id:2,name:"商鞅",ctime:new Date()},
                {id:3,name:"张仪",ctime:new Date()},
                {id:4,name:"范睢",ctime:new Date()},
                 {id:5,name:"李斯",ctime:new Date()}
            ],
            id:"",
            name:"",
            keyword:""
        }
    },
    methods: {
        //添加的方法
        add(){
            this.list.push({id:this.id,name:this.name,ctime:new Date()})
            this.id = this.name = ''
        },
        //删除的方法
        del(id){
           this.list.some((item,i)=>{
               if(item.id == id){
                   this.list.splice(i,1)
                   return true
               }
           })
        },
        //搜索的关键字
        seach(keyword){
            var arr = [];
            this.list.forEach(itme => {
                if(itme.name.indexOf(keyword) !=-1){
                    arr.push(itme)
                }
            })
            return arr
        },
    },
    filters:{
        "mytime":function(time){
            var d = new Date(time)
            var h = d.getHours()
           // alert(h)
            var m = d.getMinutes()
            var s = d.getSeconds()
            return `${h}:${m}:${s}`
        }
    },
    directives:{
        "focus":{
            bind:function(el){
                
            },
            inserted:function(el){
                el.focus()
            }
        }
    }
}
</script>

<style>
    table{
        width: 80%;
        margin:5px auto;
        border: 2px solid white;
        border-radius: 30px;
    }
    td{
        color: white;
        font-weight: bolder;
        text-align: center;
        border-right: 2px solid white;
        padding: 10px;
        border-bottom: 2px solid white;
    }
    tr > td:last-child{
        border-right: none;
    }
    tr:hover{
        background:rebeccapurple;
        color: white;
        font-weight: bolder;
        transition: all .5s ease;

    }
    .header{
   /*  border: 1px solid red; */
       width: 80%;
       height: 50px;
       margin:20px auto 0px auto;

    }
    input{
        border-radius: 10ps;
    }
    button{
      background:burlywood;
      border-radius: 10px;
      color: white;
      font-weight: bolder;
    }
    tr:last-child td{
        border-bottom: none;
    }
    .qin{
        padding-top: 50px;
        border-radius:20%;
        background-image: url(../images/b7773912b31bb05125868707397adab44aede07b.jpg);
    }
</style>