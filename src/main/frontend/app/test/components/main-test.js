import TestUtils from "react-addons-test-utils";
import Main from "../../components/main";
import React from "react";
import {expect} from "chai";

describe('Main', () => {

  it('should display introductory message', () => {
    const main = TestUtils.renderIntoDocument(<Main />);

    const heading = TestUtils.findRenderedDOMComponentWithTag(main, 'h1');

    expect(heading.innerText).to.be.eq('Working on it!');
  });

});
