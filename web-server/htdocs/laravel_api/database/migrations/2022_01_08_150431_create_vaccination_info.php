<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateVaccinationInfo extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('vaccination_info', function (Blueprint $table) {
            $table->string('vaccination_info_id');
            $table->string('vaccination_injection_1')->nullable();
            $table->string('vaccination_injection_2')->nullable();
            $table->primary('vaccination_info_id');
            $table->foreign('vaccination_injection_1')
            ->references('vaccine_id')->on('vaccine');
            $table->foreign('vaccination_injection_2')
            ->references('vaccine_id')->on('vaccine');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('vaccination_info');
    }
}
