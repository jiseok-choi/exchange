const { defineConfig } = require('@vue/cli-service')
const path = require("path")
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy : 'http://localhost:8080'
  },
  outputDir: path.resolve(__dirname, "../../src/main/resources/static")
})
