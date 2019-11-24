var path = require("path")

const htmlwepakcplugin = require("html-webpack-plugin")
const { VueLoaderPlugin } = require('vue-loader')


//const {VueLoaderPlugin} = require("vue-loader")
module.exports = {
    entry:path.join(__dirname,"./src/main.js"),
    output:{
        path:path.join(__dirname,"./dist"),
        filename:"bundle.js"
    },
    devServer:{
        open:true,
        hot:true,
        port:7788,
    },
    module:{
        rules:[
            {test:/\.vue$/,use:'vue-loader'},
        ]
    },
    plugins:[
    //    new VueLoaderPlugin(),
        new VueLoaderPlugin(),
        new htmlwepakcplugin({
            template:path.join(__dirname,"./src/index.html"),
            filename:"index.html"
        }),
        
    ],

}