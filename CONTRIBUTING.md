# Contributing to Android MVVM Template

Thanks for taking the time to contribute! This document explains how to propose changes and what
is expected of a pull request.

## Getting started

1. **Fork** the repository and clone your fork locally:

   ```bash
   git clone https://github.com/<your-username>/android-mvvm-template.git
   cd android-mvvm-template
   ```

2. Create a **branch** off `main` for your change:

   ```bash
   git checkout -b feature/short-description
   # or: fix/short-description, docs/short-description, chore/short-description
   ```

3. Make your changes, following the code style and architecture notes below.

4. Verify the project builds and tests pass before opening a PR:

   ```bash
   ./gradlew build
   ```

5. Push your branch and open a **pull request** against `main`, filling in the PR template.

## Code style

- Kotlin only, following the official Kotlin coding conventions (`kotlin.code.style=official` is
  already set in `gradle.properties`).
- Keep the existing MVVM + use case layering: Fragments/Activities talk to a `ViewModel`, the
  `ViewModel` talks to a use case, and only use cases/repositories talk to data sources. Avoid
  reaching into `data/` classes directly from the `ui/` layer.
- Prefer `StateFlow`/`Flow` over `LiveData` for new code, and model UI state as a sealed
  `Loading/Success/Error` type rather than several nullable fields.
- Use View Binding — do not add `findViewById` calls or synthetic view imports.
- This project does not yet enforce a formatter/linter in CI. If you have
  [ktlint](https://pinterest.github.io/ktlint/) or [detekt](https://detekt.dev/) configured
  locally, please run it before submitting; otherwise, match the formatting of the surrounding
  code. Adding ktlint/detekt as an official project tool is a welcome contribution on its own.

## Commit messages

Please use [Conventional Commits](https://www.conventionalcommits.org/) style prefixes where
possible, for example:

```
feat: add pagination to example list
fix: correct null handling in ExampleRepositoryImp
docs: update README architecture diagram
chore: bump Retrofit to 3.0.0
refactor: extract GetExampleListUseCase
```

Keep the subject line under ~72 characters and use the body to explain *why*, not just *what*.

## Opening issues

Before opening a new issue, please search existing issues to avoid duplicates. When filing a bug
report or feature request, use the provided templates under `.github/ISSUE_TEMPLATE/` — they help
make sure we have enough context (repro steps, environment, expected vs. actual behavior) to act
on the report quickly.

## Pull request checklist

- [ ] The project builds (`./gradlew build`) and existing tests pass.
- [ ] New behavior is covered by a unit test where practical.
- [ ] The change is scoped to a single concern (prefer several small PRs over one large PR).
- [ ] Public-facing changes (README, templates, CI) are updated alongside the code change.

## Code of Conduct

By participating in this project, you agree to abide by the
[Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md).
