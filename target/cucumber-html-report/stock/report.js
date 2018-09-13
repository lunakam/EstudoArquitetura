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
formatter.match({
  "location": "LoginSteps.iTypeInPasswordField(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click \u0027Login\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_click_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be redirect to the secure area",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_should_be_redirect_to_the_secure_area()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[Secure Area]\u003e but was:\u003c[This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.]\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:115)\n\tat org.junit.Assert.assertEquals(Assert.java:144)\n\tat io.github.lunakam.estudoarquitetura.pageObjects.LoginPage.secureAreaMessage(LoginPage.java:36)\n\tat io.github.lunakam.estudoarquitetura.stepsDefinition.LoginSteps.i_should_be_redirect_to_the_secure_area(LoginSteps.java:49)\n\tat ✽.I should be redirect to the secure area(src/test/resources/features/login.feature:8)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});