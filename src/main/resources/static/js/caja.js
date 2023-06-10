const $d = document;

$d.addEventListener("DOMContentLoaded", () => {
  initializeTable();
});

const initializeTable = () => {
  const table = $("#tablaCaja").DataTable({
    language: {
      url: "/language/datatables-es-mx.json",
    },
    responsive: true,
    fixedHeader: true,
    rowId: "0",
    columns: [null],
  });
};
