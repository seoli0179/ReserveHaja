$(document).ready(function () {

    $('#userEmail').val(addrParms("userEmail"));

    $("#submit").on('click', function (e) {
        e.preventDefault(); // 폼의 기본 제출 동작을 방지

        var userId = $("#userId").val();
        var userPassword = $("#userPassword").val();
        var userName = $("#userName").val();
        var userPhone = $("#userPhone").val();
        var userEmail = $("#userEmail").val();

        if (isId(userId) && isPw(userPassword)) {

            join(userId, userPassword, userName, userPhone, userEmail)
        } else {
            alert("4자리 이상 입력");
        }


    });
});

function isId(asValue) {
    var regExp = /^[a-z0-9]{3,19}$/g;
    return regExp.test(asValue);
}

function isPw(asValue) {
    var regExp = /^[a-z0-9]{3,19}$/g;
    return regExp.test(asValue);
}

function join(userId, userPassword, userName, userPhone, userEmail) {
    $.ajax({
        url: '/auth/join', // 로그인 처리를 위한 서버의 URL
        type: 'POST',
        data: {
            userId: userId,
            userPassword: userPassword,
            userName: userName,
            userPhone: userPhone,
            userEmail: userEmail
        },
        success: function (response) {
            console.log('회원가입 ' + response);
            if (response)
                location.replace('/');
        },
        error: function (xhr, status, error) {
            console.log('회원가입 실패:', error);
        }
    });
}

function addrParms(key) {
    var paramList = {};
    document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
        function decode(s) {
            return decodeURIComponent(s.split("+").join(" "));
        }

        paramList[decode(arguments[1])] = decode(arguments[2]);
    });
    return paramList[key];
}