import React, { Component } from 'react'
import Comment from './Comment'

const serverComments = [
    {
        id: 1,
        message: "안녕하세요. 최지원입니다.",
    }, {
        id: 2,
        message: "안녕하세요. 종강일은 12/12입니다",
    }, {
        id: 3,
        message: "11월은 쉬는 날이 없습니다.",
    }
]

class CommentList extends Component {
    constructor(props) {
        super(props)

        this.state = { // state가 변하면 render 다시 수행
            /* 
                주의점
                state안에 단순 값을 변경한다고 re-render 하지않음
                state는 주소값을 가지고 있는 포인터
                값을 바꾼다고 주소값이 바뀌진 않음 => 변경이 안됐다고 판단함
                따라서 객체를 새로 할당 해줘야 한다.
             */
            commentList: [],
        }
    }
    componentDidMount() { // 컴포넌트가 부착됬을때 실행
        // const commentList = this.state.commentList; 와 동일
        const { commentList } = this.state; // 비구조할당 -> { 변수1, 변수2, 변수3 ... } 으로 한번에 가져올 수 있어 편리

        // setInterval : 일정시간마다 특정 함수를 반복해서 실행
        setInterval(() => {
            if(commentList.length < serverComments.length){ // 더미데이터 길이만큼 state내에 데이터가 추가되면 그만하기위한 조건
                const index = commentList.length; // 0
                commentList.push(serverComments[index]);
                this.setState({
                    ...commentList
                })
            } else {
                this.setState({
                    commentList: []
                })
            }
        }, 2000)

    }

    render() {
        return (
            <div>
                {
                    this.state.commentList.map(c => {
                        return (
                            <Comment key={c.id}
                                id={c.id}
                                message={c.message}
                            />
                        )
                    })
                }
            </div>
        )
    }
}

export default CommentList;
