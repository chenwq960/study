var path = require("path")

var htmlwebpackplugin = require("html-webpack-plugin")

const { VueLoaderPlugin } = require('vue-loader')

module.exports = {
    entry:path.join(__dirname,"./src/main.js"),
    output:{
        path:path.join(__dirname,"./dist"),
        filename:"bundle.js"
    },
    devServer:{
        open:true,
        port:7788,
        hot:true,
    },
    module:{
        rules:[
            {test: /\.vue$/, use: 'vue-loader'},
            {test:/\.css$/,use:['style-loader','css-loader']},
            {test:/\.(jpg|png|jpeg|gif)$/,loader:"url-loader"},
        ]
    },
  
    plugins:[
        new VueLoaderPlugin(),
        new htmlwebpackplugin({
            template:path.join(__dirname,"./src/index.html"),
            filename:"index.html"
        }),
        
    ]

   
}