import 'whatwg-fetch';
import React from 'react';
import request from 'superagent';

export default class AddBlogPost extends React.Component {

  constructor() {
    super();
    this.state = {
      title: '',
      content: ''
    };
  }

  handleChange(event) {
    if (event.target.id === 'post-title') {
      this.setState({title: event.target.value})
    } else if (event.target.id === 'post-content') {
      this.setState({content: event.target.value})
    }
  }

  addBlogPost() {
    request.post('http://localhost:8080/post')
      .set('Accept', 'application/json')
      .set('Content-Type', 'application/json')
      .set('token', this.props.token)
      .send(this.state)
      .then(this.props.onPostAddCallback, console.error)
  }

  render() {
    return <fieldset>
      <label htmlFor="post-title">Title</label>
      <input id="post-title" type="text" name="title" maxLength="20" minLength="5" value={this.state.title}
             onChange={this.handleChange.bind(this)}/>

      <label htmlFor="post-content">Content</label>
      <textarea id="post-content" name="content" value={this.state.content} onChange={this.handleChange.bind(this)}/>

      <input type="submit" value="Add post" onClick={this.addBlogPost.bind(this)}/>
    </fieldset>
  }

}

AddBlogPost.propTypes = {
  onPostAddCallback: React.PropTypes.func,
  token: React.PropTypes.string
};

