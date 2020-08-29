const main={

init:function(){
const _this=this;

$('#btn-save').on('click',function(){
_this.save();
});

$('#btn-delete').on('click',function(){
_this.delete();
});


},

save:function(){

const data={

content:$('#content').val(),
star:false

};

$.ajax({
type:'POST',
url:'/todo',
dataType:'json',
contentType:'application/json;charset=utf-8',
data:JSON.stringify(data)
}).done(function(){
alert('할 일거리가 작성되었습니다.');
window.location.href='/';
}).fail(function(error){
alert(JSON.stringify(error));
});


},

delete:function(){


}




};

main.init();
