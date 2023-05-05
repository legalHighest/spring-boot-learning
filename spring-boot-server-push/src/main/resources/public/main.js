const app=Vue.createApp({
    data(){
        return{
            message:"hello websocket",
            id:'1',
            content:'',
            ws:null
        }
    },
    methods:{
        open(){
            console.log("open")
            ws=new WebSocket(`ws://localhost:8080/socket/${this.id}`)
        ws.onopen=()=>{
                console.log("websocket 连接成功")
        }
        ws.onclose=()=>{
                console.log("websocket 已经关闭")
        }
        ws.onerror=()=>{
                console.log("websocket 出现异常")
        }
        ws.onmessage=(res)=>{
                console.log(res)
            this.message=this.message.concat(res.data)
        }
        },
        send(){

            console.log("send")
            ws.send(this.content)
            this.content=null;
        }
    },


})