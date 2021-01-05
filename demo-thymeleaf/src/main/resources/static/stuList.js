import React, {Component} from 'react';
import 'isomorphic-fetch';
import * as ReactDOM from "react-dom";
import {BrowserRouter, Route} from "react-router-dom";

export default class stuList extends Component{
    constructor() {
        super();
        this.state = {}
    }


    async componentDidMount() {

        let students = await (await fetch('http://localhost:8080/user/all')).json();//主要是从后台拿json数据
        this.setState({students});
    }
    render() {
        let {students = []} = this.state;

        return (
            <div>
                <table className='table'>
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>姓名</th>
                        <th>年龄</th>

                    </tr>
                    </thead>
                    <tbody>
                    {students.map(({id, studentName, studentAge}) =>
                        <tr key={id}>
                            <td>{id}</td>
                            <td>{studentName}</td>
                            <td>{studentAge}</td>

                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        );
    }
}
ReactDOM.render((
        <BrowserRouter>
            <div className="container">
                <Route path="/"  exact component={stuList} />
            </div>
        </BrowserRouter>
    ),
    document.getElementById('root'));