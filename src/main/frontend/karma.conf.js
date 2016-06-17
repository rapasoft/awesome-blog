const path = require('path');
module.exports = function (config) {
  config.set({

    /**
     * These are the files required to run the tests.
     */
    files: [
      './app/polyfill/bind-polyfill.js',
      './app/polyfill/promise-polyfill.js',
      './app/test/**/*'
    ],

    /**
     * The actual tests are preprocessed by the karma-webpack plugin, so that
     * their source can be properly transpiled.
     */
    preprocessors: {
      './app/test/**/*': 'webpack'
    },

    /**
     * Start these browsers for testing. PhantomJS is a headless browser.
     * Available browsers: https://npmjs.org/browse/keyword/karma-launcher
     */
    browsers: ['PhantomJS'],

    /**
     * Use Mocha as the test framework, Sinon for mocking, and
     * Chai for assertions.
     */
    frameworks: ['mocha'],

    /**
     * The configuration for the karma-webpack plugin.
     * This is very similar to the main webpack.local.config.js.
     */
    webpack: {
      module: {
        loaders: [
          {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            query: {
              presets: ['es2015']
            }
          }
        ],
        postLoaders: [
          {
            test: /\.jsx?$/,
            exclude: /(node_modules|test|resources\/js\/vendor)/,
            loader: 'istanbul-instrumenter'
          }
        ]
      },
      resolve: {
        alias: {
          app: path.join(__dirname, 'app')
        },
        root: [path.join(__dirname, 'app'), path.join(__dirname, 'node_modules')],
        extensions: ['', '.js', '.jsx'],
        modulesDirectories: ['components', 'services', 'messages', 'img', 'node_modules']
      }
    },

    /**
     * Turn off verbose logging of webpack compilation.
     */
    webpackMiddleware: {
      noInfo: true
    },

    singleRun: false,

    /**
     * Array of plugins used
     */
    plugins: [
      'karma-mocha',
      'karma-phantomjs-launcher',
      'karma-webpack',
      'karma-coverage'
    ],

    reporters: ['progress', 'coverage'],

    coverageReporter: {
      type: 'lcov',
      dir: '../../../target/coverage/',
      subdir: '.'
    }

  });
};
