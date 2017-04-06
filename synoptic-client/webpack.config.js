var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: ['babel-polyfill','./src/main/resources/static/api/main.js'],
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel-loader'
            },
            { test: /\.json$/, loader: 'json-loader' }
            
        ]
    },
    node: {
    	  "net": "empty",
    	  "fs": "empty",
    	  "tls": "empty"
    }
};