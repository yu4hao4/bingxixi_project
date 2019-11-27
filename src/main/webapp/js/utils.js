

//post请求
function postRequest (url, params) {
    return axios({
        method: 'post',
        url: `${url}`,
        data: JSON.stringify(params),
        headers: {
            'Content-Type': 'application/json'
        }
    });
}

//get请求
function getRequest (url, params) {
    return axios({
        method: 'get',
        url: `${url}`,
        params:params,
    });
}