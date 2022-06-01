function insertBtn() {

    let formData = new FormData($('#formData')[0]);

    if (confirm('회원가입 하시겠습니까?')) {

        $.ajax
        ({
                url: '/user/singup',
                type: "POST",
                data: formData,
                dataType: 'JSON',
                enctype: 'multipart/form-data',
                cache: false,
                processData: false,
                contentType: false,
                success: function (result) {
                    console.log(result);
                    switch (result) {
                        case 1:
                            alert('가입 완료 되었습니다.');
                            location.href="/user/login";
                            break;

                        case 0:
                            alert('가입 실패. 관리자에게 문의해주십시오.');
                            break;
                    }
                }
            },
            )}
        }