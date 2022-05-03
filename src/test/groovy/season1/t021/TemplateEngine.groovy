package season1.t021

import groovy.text.StreamingTemplateEngine
import spock.lang.Specification


class TemplateEngine extends Specification {
    def "test"() {
        given: "Need templates? Try one from #groovylang TemplateEngine! #GroovyTip"
        def text = 'I support <%= firstArg %> and ${secondArg} syntax'
        def template = new StreamingTemplateEngine()
                .createTemplate(text) // or File, Reader, Url


        assert template.make([firstArg: 'JSP', secondArg: 'GString']).toString() ==
                'I support JSP and GString syntax'
    }
}