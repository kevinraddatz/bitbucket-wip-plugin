package com.pineant.bitbucket.wip;

import com.atlassian.bitbucket.hook.repository.*;
import com.atlassian.bitbucket.pull.*;
import com.atlassian.bitbucket.i18n.I18nService;

import org.springframework.beans.factory.annotation.Autowired;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.springframework.stereotype.Component;

import java.util.*;
import javax.annotation.Nonnull;

@Component("wipBlocker")
public class WipBlockCheck implements RepositoryMergeCheck {
    private final I18nService i18nService;

    @Autowired
    public WipBlockCheck(@ComponentImport I18nService i18nService) {
        this.i18nService = i18nService;
    }
    @Nonnull
    @Override
    public RepositoryHookResult preUpdate(@Nonnull PreRepositoryHookContext context,
                                          @Nonnull PullRequestMergeHookRequest request) {
        // Setup the WIP messages
        String summaryMsg = i18nService.getText("com.pineant.bitbucket.wip.summary",
                "Work in Progress");
        String detailedMsg = i18nService.getText("com.pineant.bitbucket.wip.message",
        		"Work in progress in this PR. Merging is not allowed");
        String wipStatus = "WIP:";


        // Check title of current pull request
        if (request.getPullRequest().getTitle().startsWith(wipStatus)) {
            return RepositoryHookResult.rejected(summaryMsg, detailedMsg);
        }

		// All good! Let's accept the Merge
        return RepositoryHookResult.accepted();
    } 
}