<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* relation/diagnostic_info.twig */
class __TwigTemplate_aafc742e1b3602be405af05a5506121069300197ad5c01489cd29b2c73c8264e extends \Twig\Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        // line 1
        echo "<p>";
        echo _gettext("Quick steps to set up advanced features:");
        echo "</p>

<ul>
  <li>
    ";
        // line 5
        echo sprintf(_gettext("Create the needed tables with the <code>%screate_tables.sql</code>."), twig_escape_filter($this->env, ($context["sql_dir"] ?? null)));
        echo "
    ";
        // line 6
        echo \PhpMyAdmin\Html\MySQLDocumentation::showDocumentation("setup", "linked-tables");
        echo "
  </li>
  <li>
    ";
        // line 9
        echo _gettext("Create a pma user and give access to these tables.");
        // line 10
        echo "    ";
        echo \PhpMyAdmin\Html\MySQLDocumentation::showDocumentation("config", "cfg_Servers_controluser");
        echo "
  </li>
  <li>
    ";
        // line 13
        echo _gettext("Enable advanced features in configuration file (<code>config.inc.php</code>), for example by starting from <code>config.sample.inc.php</code>.");
        // line 14
        echo "    ";
        echo \PhpMyAdmin\Html\MySQLDocumentation::showDocumentation("setup", "quick-install");
        echo "
  </li>
  <li>
    ";
        // line 17
        echo _gettext("Re-login to phpMyAdmin to load the updated configuration file.");
        // line 18
        echo "  </li>
</ul>
";
    }

    public function getTemplateName()
    {
        return "relation/diagnostic_info.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  75 => 18,  73 => 17,  66 => 14,  64 => 13,  57 => 10,  55 => 9,  49 => 6,  45 => 5,  37 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("", "relation/diagnostic_info.twig", "F:\\project2\\phpMyAdmin\\templates\\relation\\diagnostic_info.twig");
    }
}
