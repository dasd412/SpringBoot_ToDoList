const main={

init:function(){
const _this=this;

$('#btn-save').on('click',function(){
_this.save();
});

$('#tbody').click(function(e){

const unit=e.target.getAttribute('id');
if(unit=='btn-delete'){
const id=e.target.getAttribute("value");

alert(id);

_this.delete(id);
}




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

delete:function(id){


$.ajax({
type:'DELETE',
url:'/todo/'+id,
dataType:'json',
contentType:'application/json;charset=utf-8'
}).done(function(){
alert('할 일 거리를 삭제했습니다.');
window.location.href='/';
}).fail(function(error){
alert(JSON.stringify(error));
});

}


};





main.init();

