/**
 * 删除影片
 */
function delMovie(videoId) {
    var flag = confirm('确定删除吗？');
    if (flag) {
        window.location.href = "delMovie?videoId=" + videoId;
    }
}

function delMovieByAdmin(movieID) {
    var flag = confirm('确定删除吗？');
    if (flag) {
        window.location.href = "http://localhost:8080/VodPlay/delMovieByAdmin?movieid=" + movieID;
    }
}

/**
 * 编辑影片
 * @param movieID
 * @returns
 */
function editMovie(videoId, currentPage, totalPage) {
    window.location.href = "editMovie?id=" + videoId + "&currentPage=" + currentPage + "&totalPage=" + totalPage;
}

function editMovieByAdmin(movieID) {
    window.location.href = "http://localhost:8080/VodPlay/editMovieByAdmin?movieid=" + movieID;
}

function changeIsplay(movieID) {
    window.location.href = "http://localhost:8080/VodPlay/saveEditMovieByAdmin?movieId=" + movieID;
}


/**
 * 搜索影片
 * @returns
 */
function searchMovie() {
    window.location.href = "searchMovie?movieName=" + $("#movieName").val();
}