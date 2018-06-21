const create_board = new Vue({
  el: '#create_board',
  data: {
    x: 100,
    y: 100,
    bomb: 30,
    enable_submit: true
  },
  methods: {
    create: function() {
      const data = msgpack.encode({x: this.x, y: this.y, bomb: this.bomb});
      const headers = {'content-type': 'application/x-msgpack'};
      this.enable_submit = false;
      fetch('/v1/board', {method: 'POST', headers: headers, body: data})
    }
  }
});
