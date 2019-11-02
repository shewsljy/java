// 一般情况先一个页面响应加载的顺序是：域名解析-加载html-加载js和css-加载图片等其他信息。
// 那么Dom Ready应该在“加载js和css”和“加载图片等其他信息”之间，就可以操作Dom了。

// //jq默认参数是：“document”；可省略
// $().ready(function () {
//     console.log("ready.function")
// })
//
// //jq最简写
// $(function () {
//     console.log("function")
// })


//jq完整写法
$(document).ready(function () {
    console.log("document.ready.function");
})

