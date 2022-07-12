$(function(){

    const appendTodo = function(data){
        var todoCode = '<a href="#" class="todo-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
            $('#todo-list')
                .append('<div>' + todoCode + '</div>');
    };

    //Show adding todo form
    $('#show-add-todo-form').click(function){
        $('#todo-form').css('display', 'flex')
    });

    //Closing adding todo form
    $('#todo-form').click(function(event)){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting todo
    $(document).on('click', '.todo-link', function(){
        var link = $(this);
        var todoId = link.data('id');

        $.ajax({
            method:"GET",
            url: '/todos/' + todoId,
            succes: function(response)
            {
                var code = '<span>Описание дела:' + response.description + '</span>'
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Дело не найдено!')
                }
            }
        });
        return false;
    });

    //Adding todo
    $('#save-todo').click(function()
    {
        var data = $('#todo-form form').serialize();
        $ajax({
            method: "POST",
            url: '/todos/',
            data: data,
            succes: function(response)
            {
                $('#todo-form').css('display', 'none');
                var todo = {};
                todo.id = response;
                var dataArray = $('#todo-form form').serializeArray();
                for(i in dataArray) {
                    todo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTodo(todo);
            }
        });
        return false;
    });

});



