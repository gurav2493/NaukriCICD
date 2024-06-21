Feature: Update Summary in Profile

 Background:
 Given I landed on Naukri login page
 And hit login button

@UpdateSummary
Scenario Outline: Update Naukri Profile
Given Logged in with <user> and <pass>
When I have navigate to profile page
And  I updated the <Summary>
Then Profile summary Updated 
And Logout the application

Examples:
  | user                     | pass   |   Summary | 
  | gouravrajpurohit@gmail.com    | Jan!2019     | Overall having 9 year of experience in automation and manual Testing and currently working as Module Lead – QA in Infobeans Technology Private Limited |