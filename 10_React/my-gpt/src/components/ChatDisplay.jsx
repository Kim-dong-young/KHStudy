import React from 'react'
import { LoadingOutlined, UserOutlined } from '@ant-design/icons'
import { Space, Avatar, Card } from 'antd'
import styled from 'styled-components'

const ChatDisplay = ({chatDataList, isLoading}) => {
  return (
    <ChatContainer>
        {chatDataList.map((chat, index) => {
            return (
                <div key={chat.date}>
                    <Space
                        style={{
                            float: 'left'
                        }}
                    >
                        <Avatar size={40}>
                            <UserOutlined />
                        </Avatar>
                        <Card
                            style={{
                                width: 300,
                            }}
                        >
                            {chat.question}
                        </Card>
                    </Space>
                    <Space
                        style={{
                            float: 'right'
                        }}
                    >
                        <Card
                            style={{
                                width: 400,
                            }}
                        >
                            {chat.message}
                        </Card>
                        <Avatar 
                            size={40}
                            src={"https://thumb.ac-illust.com/d4/d4d8df1645a4f1e243b37cb00b857db4_t.jpeg"}
                        >
                            <UserOutlined />
                        </Avatar>
                    </Space>
                </div>
            )
        })}
        {
            isLoading &&
            <LoadingArea>
                AI 응답 작성중...
                <LoadingOutlined/>
            </LoadingArea>
        }
    </ChatContainer>
  )
}

export default ChatDisplay

const ChatContainer = styled.div`
    display: flex;
    flex-direction: column;
`
const LoadingArea = styled.div`
    padding: 12px 0;
`