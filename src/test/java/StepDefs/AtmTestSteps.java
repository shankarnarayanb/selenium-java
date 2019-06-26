package StepDefs;

import cucumber.api.java8.En;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AtmTestSteps implements En {
    private int balance;

    public AtmTestSteps() {
        Given("^I have a balance of \"([^\"]*)\"$", this::setupBankAccount);
        When("^I withdraw \"([^\"]*)\"$", this::withdrawMoney);
        Then("^I should have a balance of \"([^\"]*)\"$", this::verifyBalance);
    }

    private void setupBankAccount(String newBalance) {
        //Strips the '£' symbol and stores the balance
        balance = Integer.valueOf(newBalance.substring(1));
    }

    private void withdrawMoney(String withdrawValue) {
        balance = balance - Integer.valueOf(withdrawValue.substring(1));
        System.out.println("I now have " + balance);
    }

    private void verifyBalance(String expectedBalance) {
        assertThat(balance).isEqualTo(Integer.valueOf(expectedBalance.substring(1)));
    }

}
