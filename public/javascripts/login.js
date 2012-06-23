$(document).ready(function(){   
    if ($('.login input[type="checkbox"]').is(':checked')){
        $('.login input[type="checkbox"]').parent().attr('class', 'checkbox checked');
    }
    if (localStorage.getItem('username')) {  
        $("#id_username").val(localStorage.getItem('username')); 
    }
    $('.login input[type="checkbox"]').change( function(){
        if ($(this).is(':checked')){
            $('.login input[type="checkbox"]').parent().attr('class', 'checkbox checked');
        } else {
            $('.login input[type="checkbox"]').parent().attr('class', 'checkbox');
            
        }
    });
    
    $(".login form").submit(function() {
        if ($('.login input[type="checkbox"]').is(':checked')){
           localStorage.setItem('username', $("#id_username").val());
        } else {
            localStorage.removeItem('username');
        }
    });
});