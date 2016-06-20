require('bootstrap-webpack!../bootstrap.config.js');
require('file?name=[name].[ext]!./index.html');
require('./styles/main.less');

import React from 'react';
import ReactDOM from 'react-dom';
import Main from './components/main';

const mountNode = document.getElementById('app');

ReactDOM.render(<Main />, mountNode);

