const main={

init:function(){
const _this=this;

$('#btn-save').on('click',function(){

const data={

content:$('#content').val(),
star:false

};
if(data.content==""){
alert('빈 텍스트는 등록되지 않습니다.');
}else{
_this.save(data);
}

});

$('#tbody').click(function(e){

const unit=e.target.getAttribute('id');
const id=e.target.getAttribute("value");
if(unit=='btn-delete'){

_this.delete(id);




}
else if(unit=='td-content'){


}
else if(unit=='td-star'){

_this.updateStar(id);
}



});

},

save:function(data){


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

},

updateStar:function(id){

$.ajax({
type:'PUT',
url:'/todo/star/'+id,
dataType:'json',
contentType:'application/json;charset=utf-8'

}).done(function(){

window.location.href='/';

}).fail(function(error){
alert(JSON.stringify(error));
});

}


};





main.init();

