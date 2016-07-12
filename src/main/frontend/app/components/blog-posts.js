import React from 'react';

export default class BlogPosts extends React.Component {

  constructor(props) {
    super(props)
  }

  render() {
    if (this.props.posts && this.props.posts.length > 0) {
      return <div>
        {this.props.posts.map((post, i) => {
          return <div key={i}>
            <h2>{post.title}</h2>
            <p>{post.content}</p>
          </div>
        })}
      </div>
    } else {
      return <p>No blog posts yet.</p>
    }
  }

}

BlogPosts.propTypes = {
  posts: React.PropTypes.array
};
