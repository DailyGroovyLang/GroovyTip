package season1.t027

import spock.lang.Specification


class SubMap extends Specification {
    def "test"() {
        given: "Try Groovy 'subMap' method to filter your java.util.Map. #groovylang #GroovyTip"
        def map = [username: 'DailyGroovyLang',
                   tags    : ['groovylang', 'GroovyTip', 'GroovyTool'],
                   twitter : true,
                   github  : true]

        def filteredMap = map.subMap('twitter', 'github', 'sourceforge')

        assert filteredMap['sourceforge'] == null
        assert filteredMap == [twitter: true, github: true]
    }
}