$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login.feature");
formatter.feature({
  "name": "Login user",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have accessed the site",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_have_accessed_the_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I type \"tomsmith\" in email field",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.iTypeInEmailField(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I type \"password\" in password field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click \u0027Login\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_click_login()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I should be redirect to the secure area",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_should_be_redirect_to_the_secure_area()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});