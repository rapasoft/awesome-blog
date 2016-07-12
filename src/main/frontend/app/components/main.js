import React from 'react';
import BlogPosts from './blog-posts';
import AddBlogPost from './add-blog-post';
import request from 'superagent';

export default class Main extends React.Component {

  constructor() {
    super();
    this.state = {
      token: '',
      posts: []
    };
    this.fetchToken();
    this.fetchPosts();
  }

  fetchToken() {
    return request.post('http://localhost:8080/token')
      .send({
        username: 'blog',
        password: 'blog-password'
      })
      .set('Content-Type', 'application/json')
      .set('Accept', 'text/plain')
      .end((err, res) => {
        this.setState({token: res.text});
      });
  }

  fetchPosts() {
    if (this.state.token !== '') {
      request.get('http://localhost:8080/post')
        .set('Content-Type', 'application/json')
        .end((err, res) => {
          this.setState({posts: JSON.parse(res.text)});
        });
    }
  }

  render() {
    return <div className="container">
      <AddBlogPost onPostAddCallback={this.fetchPosts.bind(this)} token={this.state.token}/>
      <h1>List of current blog posts</h1>
      <BlogPosts posts={this.state.posts}/>
    </div>;
  }

}
