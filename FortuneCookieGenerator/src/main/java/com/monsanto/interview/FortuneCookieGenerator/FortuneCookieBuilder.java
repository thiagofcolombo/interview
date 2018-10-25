package com.monsanto.interview.FortuneCookieGenerator;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FortuneCookieBuilder {

    private static final String NOT_DEFINED = "N/A";

    private String client = NOT_DEFINED;
    private String company = NOT_DEFINED;
    private String quote = NOT_DEFINED;

    FortuneCookieBuilder withClient(String client) {
    	// Verify the client of instance to see if is not same
        if (this.client.equals(NOT_DEFINED) || !this.client.equals(client))
            this.client = client;
        return this;
    }

    FortuneCookieBuilder withCompany(String company) {
    	// Verify the company of instance to see if is not same 
        if (this.company.equals(NOT_DEFINED) || !this.company.equals(company))
            this.company = company;
        return this;
    }

    FortuneCookieBuilder withQuote(String quote) {
        if (this.quote.equals(NOT_DEFINED))
            this.quote = quote;
        return this;
    }

    FortuneCookie build() {
        return new FortuneCookie("Hi "+client+"! Thanks for buying at "+company+" :) And remember: "+quote);
    }

}
