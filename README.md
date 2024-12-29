# groq-client

Introducing a Java client for [Groq®](https://groq.com/). While official clients are available for Python and JavaScript,
this library extends the power of Groq to the JVM ecosystem, offering a seamless option for Java developers and other 
JVM-based languages.

📢 Notice: Groq® is a trademark of Groq, Inc. Groq CLI and the Groq Client are not affiliated with Groq, Inc. These tools 
are provided as interfaces to communicate with the Groq API. For more information, refer to Groq's [Trademark Policy](https://groq.com/trademark-policy/).

# Requirement
* A Groq® Cloud account. Sign up at [Groq Cloud Console](https://console.groq.com/login).
* A Groq® API key, which can be created in the Groq Cloud Console, [API keys section](https://console.groq.com/keys).
* Set your Groq® API key in the ``GROQ_API_KEY`` environment variable to enable the client to use it for making requests with the Groq client.

## How to set the ``GROQ_API_KEY`` environment variable on Windows, macOS, and Linux?

### Windows

* Open the Start Menu and search for Environment Variables.
* Click on Edit the system environment variables.
* In the System Properties window, click Environment Variables.
* Under User variables, click New, and enter:
* Variable Name: ``GROQ_API_KEY``
* Variable Value: ``your-api-key-here`` (replace this value with generated one)
* Click OK to save and close.

### macOS/Linux

Open your shell configuration file in a text editor:

#### For bash: 

```bash
~/.bashrc
```
or
```bash
~/.bash_profile
```

#### For zsh: 
```bash
~/.zshrc
```

Add the following line to the file:
```bash
export GROQ_API_KEY=your-api-key-here
```

Save the file and run:
```bash
source ~/.bashrc
```
or 
```bash
source ~/.zshrc
```

depending on your shell.

### Usage

```java
GroqClient client = new GroqClient();
GroqResponseDTO response = client.createChatCompletion(
    new GroqRequestBuilder()
        .setModel(GroqModels.LLAMA3_8B_8192)
        .setMessage(
            new MessageBuilder()
                .setRole(GroqRoles.SYSTEM)
                .setContent("<Optional: Set the behavior of the assistant by providing specific instructions for how it should behave throughout the conversation.>")
                .build()
        )
        .setMessage(
            new MessageBuilder()
                .setRole(GroqRoles.USER)
                .setContent("Can you explain compound interest?")
                .build()
        )
        .build()
);

System.out.println(response.getChoices().getFirst().getMessage().getContent());
```

### Demo

The library includes a CLI client, enabling users to select a language model and engage in conversations with the agent.

To create an executable JAR for the Groq Client, run the following command:

```bash
mvn clean compile assembly:single
```

Afterward, launch the Groq Client CLI and follow the on-screen instructions:

```bash
java -jar target/groq-client-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```


