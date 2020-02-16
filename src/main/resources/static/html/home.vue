
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <!-- import CSS -->
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<!-- import Vue before Element -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
<div id="app">
  <template v-for="(item, index) in list" :key="item.id">
    <div>{{item.text}}--{{index}}</div>
    <span>{{item.text}}</span>
  </template>
</div>

<script>
  var vm = new Vue({
    el: '#app',
    data: {
      list: [
        {
          id: "010120",
          text: "How"
        },
        {
          id: "010121",
          text: "are"
        },
        {
          id: "010122",
          text: "you"
        }
      ]
    }
  })
</script>
</body>
