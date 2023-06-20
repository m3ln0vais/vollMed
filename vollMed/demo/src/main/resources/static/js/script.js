$(() => {
    // $('.money').mask('000.000.000.000.000,00', { reverse: true });
    // $('.time').mask('00:00:00');
    $('#cep').mask('00000-000');

    $('#cep').keypress((e) => {
        if (e.which == '13') {
            e.preventDefault();
            verificaCEP()
        }
    })
})

function verificaCEP() {
    var cep = $('#cep').val()
    var url = `https://viacep.com.br/ws/${cep}/json/`

    fetch(url).then(function (response) {
        response.json().then(function (data) {
            console.log(data);
            $('#rua').val(`${data.logradouro}`)
            $('#bairro').val(`${data.bairro}`)
            $('#uf').val(`${data.uf}`)

            $('#numero').focus()
        })
    })
}