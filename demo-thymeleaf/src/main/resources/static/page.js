

function pageHelp() {
    return <p><a href="index?page=${page.firstPage}">第一页</a>
        <a href="index?page=${page.nextPage}">第二页</a>
        <a href="index?page=${page.prePage}">上一页</a>
        <a href="index?page=${page.lastPage}">最后一页</a>
    </p>

}

const element = <pageHelp />


ReactDOM.render(
    element,
    document.getElementById('page')
);