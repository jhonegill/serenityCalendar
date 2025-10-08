# Serenity Calendar Automation Tests

Automated UI test suite for jQuery Datepicker using Serenity BDD and Cucumber.

## Overview

This project contains automated acceptance tests for jQuery Datepicker functionality, validating:

- Date selection from calendar widget
- Navigation between months (current and next)
- Dynamic date selection with specific dates
- Field validation and readonly behavior
- Visual highlighting of interactions
- Cross-browser compatibility

## Tech Stack

- **Java 17**
- **Serenity BDD 4.2.34**
- **Cucumber** - Gherkin feature files
- **Maven** - Build tool
- **WebDriverManager** - Automatic driver management
- **Selenium WebDriver** - Browser automation

## Project Structure

```
src/test/
├── java/org/example/serenityCalendar/
│   ├── config/           # Test configuration
│   ├── interactions/     # Custom Screenplay interactions
│   ├── questions/        # Screenplay questions
│   ├── stepdefinitions/  # Cucumber step definitions
│   ├── tasks/            # Screenplay tasks
│   ├── userinterfaces/   # Page objects
│   └── utils/            # Utilities and helpers
└── resources/
    └── features/         # Cucumber feature files
```

## Prerequisites

- Java 17+
- Maven 3.6+
- Chrome/Firefox/Edge browser

## Quick Start

```bash
# Run all tests with default browser (Chrome headless)
mvn clean verify

# Run with specific browser
mvn clean verify -Dbrowser=chrome -Dheadless=false

# Run with Firefox
mvn clean verify -Dbrowser=firefox

# Run with Edge
mvn clean verify -Dbrowser=edge
```

## Manual Execution

1. **Execute Tests**
   ```bash
   mvn clean verify -Dcucumber.options="--tags @Test1"
   ```

2. **Generate Reports**
   ```bash
   mvn serenity:aggregate
   ```

## Test Scenarios

### Date Selection

- ✅ Select day from current month
- ✅ Select day from next month
- ✅ Select specific date dynamically
- ✅ Navigate between months

### Field Validation

- ✅ Validate selected date appears in input field
- ✅ Verify field is not manually editable
- ✅ Test readonly behavior

### Visual Interactions

- ✅ Element highlighting during interactions
- ✅ Screenshot capture for evidence
- ✅ Visual feedback for user actions

### Test Tags

- `@Test1` - Main datepicker functionality tests
- `@Test2` - Dynamic date selection tests

## Configuration

### Browser Configuration

Test configuration in `serenity.properties`:

```properties
# Default browser settings
webdriver.driver = chrome
webdriver.headless = true
serenity.browser.maximized = true

# Timeouts
webdriver.timeouts.implicitlywait = 5000
webdriver.wait.for.timeout = 5000

# Base URL
webdriver.base.url = https://jqueryui.com/datepicker/
```

### Test Execution Options

**Using Maven**
```bash
# Run all tests
mvn clean verify

# Run with specific browser
mvn clean verify -Dbrowser=chrome -Dheadless=false

# Run specific tags
mvn clean verify -Dcucumber.options="--tags @Test1"

# Run with custom browser settings
mvn clean verify -Dbrowser=firefox -Dheadless=true
```

## Reports

Serenity reports are generated at: `target/site/serenity/index.html`

## Troubleshooting

**Browser Driver Issues:**
```bash
# WebDriverManager handles drivers automatically
# Check console output for driver setup messages
```

**Test Failures:**
```bash
# Check screenshots in Serenity reports
# Review target/site/serenity/index.html
```

**Headless Mode Issues:**
```bash
# Run in headed mode for debugging
mvn clean verify -Dheadless=false
```

## Development

### Adding New Tests

1. Create feature files in `src/test/resources/features/`
2. Implement step definitions in `src/test/java/.../stepdefinitions/`
3. Create tasks and questions following Screenplay pattern
4. Add appropriate tags for test categorization
5. Update this README if new test categories are added

### Running Specific Test Categories

```bash
# Run main functionality tests
mvn verify -Dcucumber.options="--tags @Test1"

# Run dynamic date selection tests
mvn verify -Dcucumber.options="--tags @Test2"

# Run all tests
mvn verify -Dcucumber.options="--tags @Test1 or @Test2"
```

### Browser Support

The framework supports:
- **Chrome** (default)
- **Firefox**
- **Edge**

All browsers support both headed and headless execution modes.