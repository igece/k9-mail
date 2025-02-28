package app.k9mail.feature.account.edit.ui.server.settings.save

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.k9mail.core.ui.compose.designsystem.molecule.ContentLoadingErrorView
import app.k9mail.core.ui.compose.designsystem.molecule.ErrorView
import app.k9mail.core.ui.compose.designsystem.molecule.LoadingView
import app.k9mail.core.ui.compose.designsystem.template.ResponsiveWidthContainer
import app.k9mail.core.ui.compose.theme.PreviewWithThemes
import app.k9mail.feature.account.common.ui.loadingerror.rememberContentLoadingErrorViewState
import app.k9mail.feature.account.common.ui.view.SuccessView
import app.k9mail.feature.account.edit.R

@Composable
fun SaveServerSettingsContent(
    state: SaveServerSettingsContract.State,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    ResponsiveWidthContainer(
        modifier = Modifier
            .testTag("SaveServerSettingsContent")
            .padding(contentPadding)
            .then(modifier),
    ) {
        ContentLoadingErrorView(
            state = rememberContentLoadingErrorViewState(state),
            loading = {
                LoadingView(
                    message = stringResource(id = R.string.account_edit_save_server_settings_loading_message),
                )
            },
            error = {
                ErrorView(
                    title = stringResource(id = R.string.account_edit_save_server_settings_error_message),
                )
            },
            content = {
                SuccessView(
                    message = stringResource(id = R.string.account_edit_save_server_settings_success_message),
                )
            },
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun UpdateServerSettingsContentPreview() {
    PreviewWithThemes {
        SaveServerSettingsContent(
            state = SaveServerSettingsContract.State(
                isLoading = false,
                error = null,
            ),
            contentPadding = PaddingValues(),
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun UpdateServerSettingsContentLoadingPreview() {
    PreviewWithThemes {
        SaveServerSettingsContent(
            state = SaveServerSettingsContract.State(
                isLoading = true,
                error = null,
            ),

            contentPadding = PaddingValues(),
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun UpdateServerSettingsContentErrorPreview() {
    PreviewWithThemes {
        SaveServerSettingsContent(
            state = SaveServerSettingsContract.State(
                isLoading = false,
                error = SaveServerSettingsContract.Failure.SaveServerSettingsFailed(
                    message = "Error",
                ),
            ),
            contentPadding = PaddingValues(),
        )
    }
}
